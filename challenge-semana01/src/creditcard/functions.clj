(ns creditcard.functions
  (:require [creditcard.db :as c.db]))

(group-by :category (c.db/all-records))
; {
; Transporte [
;   {:customer-id 1, :date 2021-11-21T08:34:26, :value 100, :place Posto de Gasolina, :category Transporte}
;   {:customer-id 1, :date 2021-11-23T11:55:05, :value 30, :place Taxi, :category Transporte}
;   {:customer-id 1, :date 2021-11-25T08:40:12, :value 60, :place Posto de Gasolina, :category Transporte}
;   {:customer-id 1, :date 2021-11-25T11:10:15, :value 65, :place Taxi, :category Transporte}
;   {:customer-id 1, :date 2021-11-25T17:45:28, :value 45, :place Taxi, :category Transporte}],

; Alimentação [
;   {:customer-id 1, :date 2021-11-22T09:35:00, :value 80, :place Pizzaria, :category Alimentação}
;   {:customer-id 1, :date 2021-11-23T16:07:05, :value 20, :place Padaria, :category Alimentação}
;   {:customer-id 1, :date 2021-11-24T09:30:11, :value 700, :place Supermercado, :category Alimentação}
;   {:customer-id 1, :date 2021-11-25T09:07:01, :value 35, :place Padaria, :category Alimentação}
;   {:customer-id 1, :date 2021-11-25T17:30:45, :value 200, :place Supermercado, :category Alimentação}],

; Saúde [
;   {:customer-id 1, :date 2021-11-22T10:37:15, :value 150, :place Dentista, :category Saúde}],

; Lazer [
;   {:customer-id 1, :date 2021-11-23T08:20:20, :value 90, :place Cinema, :category Lazer}
;   {:customer-id 1, :date 2021-11-24T12:12:12, :value 140, :place Parque, :category Lazer}],

; Estudos [
;   {:customer-id 1, :date 2021-11-24T18:22:24, :value 120, :place Apostilas, :category Estudos}
;   {:customer-id 1, :date 2021-11-24T18:37:25, :value 350, :place Curso, :category Estudos}]
; }

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
;(
; {:category Transporte, :num-records 5, :total-amount 300}
; {:category Alimentação, :num-records 5, :total-amount 1035}
; {:category Saúde, :num-records 1, :total-amount 150}
; {:category Lazer, :num-records 2, :total-amount 230}
; {:category Estudos, :num-records 2, :total-amount 470}
; )