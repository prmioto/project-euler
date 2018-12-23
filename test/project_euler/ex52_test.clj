(ns project-euler.ex52-test
  (:require [clojure.test :refer :all]
            [project-euler.ex52 :refer :all]))

(deftest same-digits-tests
  (testing
    (is (= true (same-digits? "1" "1"))))            
  (testing
    (is (= true (same-digits? "12" "21"))))    
  (testing
    (is (= true (same-digits? "125874" "251748")))))

(deftest get-multiples-tests
  (testing
    (is (= '(1 2 3) (get-multiples 1 3))))            
  (testing
    (is (= '(123 246 369 492)  (get-multiples 123 4)))))

    
(deftest multiples-same-digits-tests
  (testing
    (is (false? (multiples-same-digits? 1 3))))
  (testing
    (is (true? (multiples-same-digits? 142857 6)))))