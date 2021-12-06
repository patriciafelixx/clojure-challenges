(ns creditcard.db)

(defn get-creditcard []
  {:number   "1654658431352967"
   :validate "07/10/2029"
   :limit    5000.00
   :cvv      321
   :customer {:id    1
              :name  "Fulano X"
              :cpf   "123.456.789-10"
              :email "fulanox@email.com"}})

(defn all-records []
  [{:creditcard-number "1654658431352967", :date "2021-10-21T08:34:26", :value 100.00, :place "Posto de Gasolina", :category "Transporte"},
   {:creditcard-number "1654658431352967", :date "2021-10-24T09:35:00", :value 80.00, :place "Pizzaria", :category "Alimentação"},
   {:creditcard-number "1654658431352967", :date "2021-10-25T10:37:15", :value 150.00, :place "Dentista", :category "Saúde"},
   {:creditcard-number "1654658431352967", :date "2021-10-28T18:20:20", :value 90.00, :place "Cinema", :category "Lazer"},
   {:creditcard-number "1654658431352967", :date "2021-10-28T21:55:05", :value 30.00, :place "Taxi", :category "Transporte"},
   {:creditcard-number "1654658431352967", :date "2021-10-30T16:07:05", :value 20.00, :place "Padaria", :category "Alimentação"},
   {:creditcard-number "1654658431352967", :date "2021-11-01T09:30:11", :value 700.00, :place "Supermercado", :category "Alimentação"},
   {:creditcard-number "1654658431352967", :date "2021-11-02T12:12:12", :value 140.00, :place "Parque", :category "Lazer"},
   {:creditcard-number "1654658431352967", :date "2021-11-05T18:22:24", :value 60.00, :place "Papelaria", :category "Estudos"},
   {:creditcard-number "1654658431352967", :date "2021-11-05T18:37:25", :value 350.00, :place "Curso", :category "Estudos"},
   {:creditcard-number "1654658431352967", :date "2021-11-07T08:40:12", :value 120.00, :place "Posto de Gasolina", :category "Transporte"},
   {:creditcard-number "1654658431352967", :date "2021-11-07T09:07:01", :value 35.00, :place "Padaria", :category "Alimentação"},
   {:creditcard-number "1654658431352967", :date "2021-11-10T11:10:15", :value 65.00, :place "Taxi", :category "Transporte"},
   {:creditcard-number "1654658431352967", :date "2021-11-10T17:30:45", :value 200.00, :place "Supermercado", :category "Alimentação"},
   {:creditcard-number "1654658431352967", :date "2021-11-11T17:45:28", :value 45.00, :place "Taxi", :category "Transporte"}])