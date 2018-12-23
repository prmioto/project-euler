(ns project-euler.ex50-test
  (:require [clojure.test :refer :all]
            [project-euler.ex50 :refer :all]))

(deftest longest-sum-of-consecutive-primes-below-tests
  (testing
    (is (= 17 (longest-sum-of-consecutive-primes-below 10))))            
  (testing
    (is (= 41 (longest-sum-of-consecutive-primes-below 20)))))
