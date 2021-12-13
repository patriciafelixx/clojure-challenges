(ns creditcard.schema)

(def schema [
             ; COSTUMER
             {:db/ident       :costumer/id
              :db/valueType   :db.type/uuid
              :db/unique      :db.unique/identity
              :db/cardinality :db.cardinality/one}

             {:db/ident       :costumer/name
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one}

             {:db/ident       :costumer/cpf
              :db/valueType   :db.type/string
              :db/unique      :db.unique/identity
              :db/cardinality :db.cardinality/one}

             {:db/ident       :costumer/email
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one}

             ;------------------------------------
             ; CREDIT CARD
             {:db/ident       :creditcard/id
              :db/valueType   :db.type/uuid
              :db/unique      :db.unique/identity
              :db/cardinality :db.cardinality/one}

             {:db/ident       :creditcard/number
              :db/valueType   :db.type/string
              :db/unique      :db.unique/identity
              :db/cardinality :db.cardinality/one}

             {:db/ident       :creditcard/validate
              :db/valueType   :db.type/instant
              :db/cardinality :db.cardinality/one}

             {:db/ident       :creditcard/limit
              :db/valueType   :db.type/bigdec
              :db/cardinality :db.cardinality/one}

             {:db/ident       :creditcard/cvv
              :db/valueType   :db.type/long
              :db/cardinality :db.cardinality/one}

             {:db/ident       :creditcard/customer
              :db/valueType   :db.type/ref
              :db/cardinality :db.cardinality/one}

             ;------------------------------------
             ; TRANSACTION
             {:db/ident       :transaction/id
              :db/valueType   :db.type/uuid
              :db/unique      :db.unique/identity
              :db/cardinality :db.cardinality/one}

             {:db/ident       :transaction/date
              :db/valueType   :db.type/instant
              :db/cardinality :db.cardinality/one}

             {:db/ident       :transaction/value
              :db/valueType   :db.type/bigdec
              :db/cardinality :db.cardinality/one}

             {:db/ident       :transaction/place
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one}

             {:db/ident       :transaction/category
              :db/valueType   :db.type/string
              :db/cardinality :db.cardinality/one}

             {:db/ident       :transaction/card
              :db/valueType   :db.type/ref
              :db/cardinality :db.cardinality/one}

             {:db/ident       :transaction/customer
              :db/valueType   :db.type/ref
              :db/cardinality :db.cardinality/one}])
