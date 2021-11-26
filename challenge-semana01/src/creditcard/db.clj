(ns creditcard.db)

;------------------------------------------------------------------------------------
;CUSTOMERS AND CARDS
(def creditcard {:number   "1654658431354"
                 :validate "07/10/2029"
                 :limit    5000.00
                 :cvv      321
                 :customer {:id         1
                            :name       "Fulano X"
                            :cpf        "123.456.789-10"
                            :email      "fulanox@email.com"}})

(defn get-creditcard []
      [creditcard])

;------------------------------------------------------------------------------------
; TRANSACTIONS

(def record1 {:creditcard-number   "1654658431354"
              :date                 "2021-11-21T08:34:26"
              :value                100.00
              :place                "Posto de Gasolina"
              :category             "Transporte"})

(def record2 {:creditcard-number   "1654658431354"
              :date                "2021-11-22T09:35:00"
              :value               80.00
              :place               "Pizzaria"
              :category            "Alimentação"})

(def record3 {:creditcard-number   "1654658431354"
              :date                "2021-11-22T10:37:15"
              :value               150.00
              :place               "Dentista"
              :category            "Saúde"})

(def record4 {:creditcard-number   "1654658431354"
              :date                "2021-11-23T08:20:20"
              :value                90.00
              :place               "Cinema"
              :category            "Lazer"})

(def record5 {:creditcard-number   "1654658431354"
              :date                "2021-11-23T11:55:05"
              :value               30.00
              :place               "Taxi"
              :category            "Transporte"})

(def record6 {:creditcard-number   "1654658431354"
              :date                "2021-11-23T16:07:05"
              :value               20.00
              :place               "Padaria"
              :category            "Alimentação"})

(def record7 {:creditcard-number   "1654658431354"
              :date                "2021-11-24T09:30:11"
              :value               700.00
              :place               "Supermercado"
              :category            "Alimentação"})

(def record8 {:creditcard-number   "1654658431354"
              :date                "2021-11-24T12:12:12"
              :value               140.00
              :place               "Parque"
              :category            "Lazer"})

(def record9 {:creditcard-number   "1654658431354"
              :date                "2021-11-24T18:22:24"
              :value               120.00
              :place               "Apostilas"
              :category            "Estudos"})

(def record10 {:creditcard-number   "1654658431354"
               :date                "2021-11-24T18:37:25"
               :value               350.00
               :place               "Curso"
               :category            "Estudos"})

(def record11 {:creditcard-number   "1654658431354"
               :date                "2021-11-25T08:40:12"
               :value               60.00
               :place               "Posto de Gasolina"
               :category            "Transporte"})

(def record12 {:creditcard-number   "1654658431354"
               :date                "2021-11-25T09:07:01"
               :value               35.00
               :place               "Padaria"
               :category            "Alimentação"})

(def record13 {:creditcard-number   "1654658431354"
               :date                "2021-11-25T11:10:15"
               :value               65.00
               :place               "Taxi"
               :category            "Transporte"})

(def record14 {:creditcard-number   "1654658431354"
               :date                "2021-11-25T17:30:45"
               :value               200.00
               :place               "Supermercado"
               :category            "Alimentação"})

(def record15 {:creditcard-number   "1654658431354"
               :date                "2021-11-25T17:45:28"
               :value               45.00
               :place               "Taxi"
               :category            "Transporte"})

(defn all-records []
      [record1, record2, record3, record4, record5, record6, record7, record8, record9, record10, record11, record12, record13, record14, record15])

