(ns creditcard.db)

(def customer1 {:id         1
                :name       "Fulano X"
                :cpf        "123.456.789-10"
                :email      "fulanox@email.com"
                :creditcard {:number   "1654658431354"
                             :validate "07/10/2029"
                             :limit    5000
                             :cvv      321}})