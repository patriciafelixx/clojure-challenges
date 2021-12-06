(ns creditcard.logic-test
  (:require [clojure.test :refer :all]
            [creditcard.logic :refer :all]
            [creditcard.model :as c.model]
            [schema.core :as s]))

(s/set-fn-validation! true)

(deftest total-by-item-test
  (testing "Returns map grouped by item when all record data is valid"
    (let [list [{:creditcard-number "1234567887654321", :date "2021-12-03T13:25:00", :value 1.00, :place "X", :category "one"}
                {:creditcard-number "1234567887654321", :date "2021-12-03T14:25:00", :value 2.00, :place "Y", :category "two"}
                {:creditcard-number "1234567887654321", :date "2021-12-03T15:25:00", :value 3.00, :place "Z", :category "one"}]
          group :category]
      (is (= [{:item "one", :total-value 4.0} {:item "two", :total-value 2.0}]
             (total-by-item list group)))))

  (testing "No returns when card number is invalid"
    ; ExceptionInfo => {:creditcard-number (not (creditcard.model/valid-card?))}
    (let [list [{:creditcard-number "12345678", :date "2021-12-03T13:25:00", :value 1.00, :place "X", :category "one"}]
          group :category]
      (is (thrown? clojure.lang.ExceptionInfo
                   (total-by-item list group)))))

  (testing "No returns when date is invalid"
    ; ExceptionInfo => {:date (throws? (creditcard.model/valid-date?))}
    (let [list [{:creditcard-number "1234567887654321", :date "3333", :value 1.00, :place "X", :category "one"}]
          group :category]
      (is (thrown? clojure.lang.ExceptionInfo
                   (total-by-item list group)))))

  (testing "No returns when required keys are missing"
    ; ExceptionInfo => {:place missing-required-key}
    (let [list [{:creditcard-number "1234567887654321", :date "2021-12-03T14:25:00", :category "two"}]
          group :category]
      (is (thrown? clojure.lang.ExceptionInfo
                   (total-by-item list group)))))

  (testing "No returns when value is negative"
    (let [list [{:creditcard-number "1234567887654321", :date "2021-12-03T14:25:00", :value -2, :place "Y", :category "two"}]
          group :category]
      (is (thrown? clojure.lang.ExceptionInfo
                   (total-by-item list group))))))

(deftest total-value-test
  (let [records  [{:creditcard-number "1234567887654321", :date "2021-12-03T13:25:00", :value 1.00, :place "X", :category "one"}
                  {:creditcard-number "1234567887654321", :date "2021-12-03T14:25:00", :value 2.00, :place "Y", :category "two"}
                  {:creditcard-number "1234567887654321", :date "2021-12-03T15:25:00", :value 3.00, :place "Z", :category "one"}]
        total (reduce + (map :value records))]
  (testing "Returns the value when it is within the limit"
    (is (= 6.00 (total-value 6.00 records))))

  (testing "No returns the value when it is within the limit"
    (is (thrown? clojure.lang.ExceptionInfo (total-value 5.99 records))))))