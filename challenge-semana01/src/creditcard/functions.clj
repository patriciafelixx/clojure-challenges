(ns creditcard.functions
  (:require [creditcard.db :as c.db]))

(group-by :category (c.db/all-records))

(defn total-value [records]
  (->> records
       (map :value)
       (reduce +)))

(defn by-item
  [[category records]]
  {:category category
   :num-records (count records)
   :total-amount (total-value records)})

(->> (c.db/all-records)
     (group-by :category)
     (map by-item)
     println)
