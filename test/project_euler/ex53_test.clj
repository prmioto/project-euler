(ns project-euler.ex53-test
  (:require [clojure.test :refer :all]
            [project-euler.ex53 :refer :all]))

(deftest factorial-tests
  (testing
    (is (= 1 (factorial 0))))            
  (testing
    (is (= 1 (factorial 1))))    
  (testing
    (is (= 120 (factorial 5))))
  (testing
    (is (= 720 (factorial 6)))))
    
(deftest combinations-tests
  (testing
    (is (= 10 (combinations 5 3))))            
  (testing
    (is (= 1144066N  (combinations 23 10)))))

(deftest combinations-greater-than-tests
  (testing
    (is (= 5 (count(combinations-greater-than 10 100)))))
  (testing
    (is (= 2 (count(combinations-greater-than 5 9))))))