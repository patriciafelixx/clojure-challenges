(ns creditcard.functions
  (:require [creditcard.db :as c.db]))

; ------------------------------------------------------------------------------------------------------
(println "=> TOTAL BY CATEGORIES")

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

; ------------------------------------------------------------------------------------------------------
(println "=> TOTAL BY PLACES")

(defn by-place
  [[place records]]
  {:place place
   :num-records (count records)
   :total-amount (total-value records)})

(->> (c.db/all-records)
     (group-by :place)
     (map by-place)
     println)