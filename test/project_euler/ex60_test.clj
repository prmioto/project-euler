(ns project-euler.ex60-test
  (:require [clojure.test :refer :all]
            [project-euler.ex60 :refer :all]))

(deftest combinations-tests
    (testing
      (is (= [[1] [2] [3]] (combinations [1 2 3] 1)))
      (is (= [[1 2] [1 3] [2 3]] (combinations [1 2 3] 2)))
      (is (= [[1 2 3]] (combinations [1 2 3] 3))))
  (testing
    (let [combs (combinations [1 2 3 4 5 6] 3)]
        (is (= 20 (count combs)))
      (is (= [1 2 3] (first combs)))
      (is (= [4 5 6] (last combs)))))
  (testing
      (is (= 
             '([1 2 3 4] [1 2 3 5] [1 2 3 6] [1 2 4 5] [1 2 4 6] [1 2 5 6] 
               [1 3 4 5] [1 3 4 6] [1 3 5 6] 
               [1 4 5 6] 
               [2 3 4 5] [2 3 4 6] [2 3 5 6] 
               [2 4 5 6] 
               [3 4 5 6]) (combinations [1 2 3 4 5 6] 4)))))

