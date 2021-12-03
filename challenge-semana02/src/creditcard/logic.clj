(ns creditcard.logic
  (:require [creditcard.db :as c.db]
            [java-time :as jt]))

(defn all-records []
  "Returns all transaction records "
  (c.db/all-records))

(defn total-value
  [records]
  (reduce + (map :value records)))

(defn by-item
  [[item records]]
  {:category    item
   :total-value (total-value records)})

(defn total-by-item
  "Returns all records grouped"
  [list group]
  (map by-item (group-by group list)))

(defn filter-by-item
  "Returns all records for a specific filter"
  [key item]
  (filter #(= item (key %)) (all-records)))

(defn invoice
  [card-number period]
  "Returns invoice value filtered by month"
  (->> (filter-by-item :creditcard-number card-number)
       (filter #(= (jt/year (jt/local-date "dd/MM/yyyy" period)) (jt/year (jt/local-date-time (:date %)))))
       (filter #(= (jt/month (jt/local-date "dd/MM/yyyy" period)) (jt/month (jt/local-date-time (:date %)))))
       total-value))