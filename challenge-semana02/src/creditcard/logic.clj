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

(s/defn get-creditcard
  []
  "Returns creditcard"
  (c.db/get-creditcard))

(defn total-value
  [limit-creditcard records]
  (let [total (reduce + (map :value records))]
  (if (<= total limit-creditcard)
    total
    (throw (ex-info "Limite do cartão ultrapassado!"
                    {:limit limit-creditcard :total total})))))

(defn by-item
  [[item records]]
  {:item    item
   :total-value (total-value (:limit (get-creditcard)) records)})

(s/defn total-by-item
  "Returns all records grouped"
  [list :- [c.model/Record] group :- s/Keyword]
  (map by-item (group-by group list)))

(s/defn filter-by-item :- [c.model/Record]
  "Returns all records for a specific filter"
  [list :- [c.model/Record] key :- s/Keyword item]
  (filter #(= item (key %)) list))

(s/defn invoice :- c.model/Value
  [card-number :- c.model/CreditCardNumber period :- s/Str]
  "Returns invoice value filtered by month"
  (->> (filter-by-item (all-records) :creditcard-number card-number)
       (filter #(= (jt/year (jt/local-date "dd/MM/yyyy" period)) (jt/year (jt/local-date-time (:date %)))))
       (filter #(= (jt/month (jt/local-date "dd/MM/yyyy" period)) (jt/month (jt/local-date-time (:date %)))))
       (total-value (:limit (get-creditcard)))))
       ;(total-value 100.00)))
