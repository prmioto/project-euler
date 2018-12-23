(ns project-euler.ex44-test
  (:require [clojure.test :refer :all]
            [project-euler.ex44 :refer :all]))

(deftest a-test
  (testing "calculate pentagon numbers"
    (is (= 1 (pentagon-number 1)))
    (is (= 5 (pentagon-number 2)))
    (is (= 12 (pentagon-number 3))))
  (testing "calculate first 10 pentagon numbers"
    (is (= '(1, 5, 12, 22, 35, 51, 70, 92, 117, 145) (take 10 (map pentagon-number (iterate inc 1)))))))

    
(deftest b-test
  (testing "calculate quadratic roots"
    (is (= [1 -4] (calc-quadratic-roots 1 3 -4)))
    (is (= [20 1] (calc-quadratic-roots 1 -3 2)))
    (is (= [2 1] (calc-quadratic-roots 1 -3.000001 20)))
    (is (= [1 -4] (calc-quadratic-roots 3 -1 (* -2 35))))
    (is (= [10 -4] (calc-quadratic-roots 3 -1 (* -2 145))))
    (is (= [10 -4] (calc-quadratic-roots 3 -1 (* -2 147))))
    (is (integer? (first (calc-quadratic-roots 3 -1 (* -2 147)))))
    ))
   
(deftest b-test
  (testing "check if is a pentagon number"
    (is (is-pentagon-number? 1))
    (is (is-pentagon-number? 35))
    (is (is-pentagon-number? 145))
    (is (not (is-pentagon-number? 1557)))))
