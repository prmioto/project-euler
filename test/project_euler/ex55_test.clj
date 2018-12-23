(ns project-euler.ex55-test
  (:require [clojure.test :refer :all]
            [project-euler.ex55 :refer :all]))

(deftest reverse-number-tests
    (testing
        (is (= 1 (reverse-number 1)))
        (is (= 21 (reverse-number 12)))
        (is (= 321 (reverse-number 123)))
        (is (= 7654321 (reverse-number 1234567)))))
        
(deftest palindrome-tests
    (testing
        (is (true? (palindrome? 1)))
        (is (false? (palindrome? 12)))
        (is (true? (palindrome? 121)))
        (is (false? (palindrome? 1234)))
        (is (true? (palindrome? 12344321)))
        (is (true? (palindrome? 123454321)))
        (is (true? (palindrome? 4668731596684224866951378664)))))
        
(deftest likely-lychrel-number-tests
    (testing
        (let [max-iterations 50]
            (is (true? (likely-lychrel-number? 196 max-iterations)))
            (is (false? (likely-lychrel-number? 47 max-iterations)))
            (is (false? (likely-lychrel-number? 349 max-iterations))))))