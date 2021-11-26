(ns creditcard.db)

;------------------------------------------------------------------------------------
;CUSTOMERS AND CARDS

(def customer1 {:id         1
                :name       "Fulano X"
                :cpf        "123.456.789-10"
                :email      "fulanox@email.com"
                :creditcard {:number   "1654658431354"
                             :validate "07/10/2029"
                             :limit    5000
                             :cvv      321}})

(defn all-customers []
  [customer1])

;------------------------------------------------------------------------------------
; TRANSACTIONS

(def record1 {:customer-id 1
              :date        "2021-11-21T08:34:26"
              :value       100
              :place       "Posto de Gasolina"
              :category    "Transporte"})

(def record2 {:customer-id 1
              :date        "2021-11-22T09:35:00"
              :value       80
              :place       "Pizzaria"
              :category    "Alimentação"})

(def record3 {:customer-id 1
              :date        "2021-11-22T10:37:15"
              :value       150
              :place       "Dentista"
              :category    "Saúde"})

(def record4 {:customer-id 1
              :date        "2021-11-23T08:20:20"
              :value       90
              :place       "Cinema"
              :category    "Lazer"})

(def record5 {:customer-id 1
              :date        "2021-11-23T11:55:05"
              :value       30
              :place       "Taxi"
              :category    "Transporte"})

(def record6 {:customer-id 1
              :date        "2021-11-23T16:07:05"
              :value       20
              :place       "Padaria"
              :category    "Alimentação"})

(def record7 {:customer-id 1
              :date        "2021-11-24T09:30:11"
              :value       700
              :place       "Supermercado"
              :category    "Alimentação"})

(def record8 {:customer-id 1
              :date        "2021-11-24T12:12:12"
              :value       140
              :place       "Parque"
              :category    "Lazer"})

(def record9 {:customer-id 1
              :date        "2021-11-24T18:22:24"
              :value       120
              :place       "Apostilas"
              :category    "Estudos"})

(def record10 {:customer-id 1
               :date        "2021-11-24T18:37:25"
               :value       350
               :place       "Curso"
               :category    "Estudos"})

(def record11 {:customer-id 1
               :date        "2021-11-25T08:40:12"
               :value       60
               :place       "Posto de Gasolina"
               :category    "Transporte"})

(def record12 {:customer-id 1
               :date        "2021-11-25T09:07:01"
               :value       35
               :place       "Padaria"
               :category    "Alimentação"})

(def record13 {:customer-id 1
               :date        "2021-11-25T11:10:15"
               :value       65
               :place       "Taxi"
               :category    "Transporte"})

(def record14 {:customer-id 1
               :date        "2021-11-25T17:30:45"
               :value       200
               :place       "Supermercado"
               :category    "Alimentação"})

(def record15 {:customer-id 1
               :date        "2021-11-25T17:45:28"
               :value       45
               :place       "Taxi"
               :category    "Transporte"})

(defn all-records []
  [record1, record2, record3, record4, record5, record6, record7, record8, record9, record10, record11, record12, record13, record14, record15])

