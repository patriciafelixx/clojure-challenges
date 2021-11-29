(ns creditcard.functions
  (:require [creditcard.db :as c.db]
            [java-time :as jt]))

; ------------------------------------------------------------------------------------------------------
(println "=> TOTAL BY CATEGORIES")

(defn total-value [records]
  (->> records
       (map :value)
       (reduce +)))

(defn by-item
  [[category records]]
  {:category     category
   :num-records  (count records)
   :total-amount (total-value records)})

(->> (c.db/all-records)
     (group-by :category)
     (map by-item)
     println)

; ------------------------------------------------------------------------------------------------------
(println "=> TOTAL BY PLACES")

(defn by-place
  [[place records]]
  {:place        place
   :num-records  (count records)
   :total-amount (total-value records)})

(->> (c.db/all-records)
     (group-by :place)
     (map by-place)
     println)

; ------------------------------------------------------------------------------------------------------
(println "=> CREDIT CARD INVOICE")

(defn invoice
  [card-number period]
  (->> (c.db/all-records)
       (filter #(= card-number (:creditcard-number %)))
       (filter #(= (jt/year (jt/local-date "dd/MM/yyyy" period)) (jt/year (jt/local-date-time (:date %)))))
       (filter #(= (jt/month (jt/local-date "dd/MM/yyyy" period)) (jt/month (jt/local-date-time (:date %)))))
       total-value
       println))

(invoice "1654658431352967" "01/11/2021")

; ------------------------------------------------------------------------------------------------------