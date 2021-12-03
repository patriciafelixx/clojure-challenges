(ns creditcard.logic
  (:require [creditcard.db :as c.db]
            [java-time :as jt]
            [creditcard.model :as c.model]
            [schema.core :as s]))

(s/set-fn-validation! true)

(s/defn all-records :- [c.model/Record]
  []
  "Returns all transaction records "
  (c.db/all-records))

(defn total-value
  [records]
  (reduce + (map :value records)))

(defn by-item
  [[item records]]
  {:item    item
   :total-value (total-value records)})

(s/defn total-by-item
  "Returns all records grouped"
  [list :- [c.model/Record] group :- s/Keyword]
  (map by-item (group-by group list)))

(s/defn filter-by-item :- [c.model/Record]
  "Returns all records for a specific filter"
  [key :- s/Keyword item]
  (filter #(= item (key %)) (all-records)))

(s/defn invoice :- s/Num
  [card-number :- s/Str period :- s/Str]
  "Returns invoice value filtered by month"
  (->> (filter-by-item :creditcard-number card-number)
       (filter #(= (jt/year (jt/local-date "dd/MM/yyyy" period)) (jt/year (jt/local-date-time (:date %)))))
       (filter #(= (jt/month (jt/local-date "dd/MM/yyyy" period)) (jt/month (jt/local-date-time (:date %)))))
       total-value))