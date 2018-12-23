(ns project-euler.ex48-test
  (:require [clojure.test :refer :all]
            [project-euler.ex48 :refer :all]))            
            
(deftest last-chars-tests
    (testing "last-chars function"
        (is (= "DFG" (last-chars "ABCDFG" 3)))
        (is (= "67890" (last-chars (str 1234567890) 5)))))
            
(deftest power-functions-tests
  (testing "power function"
    (is (= 1 (power 1N 1N)))
    (is (= 1 (power 1N 2N)))
    (is (= 4 (power 2N 2N)))
    (is (= 1024 (power 2N 10N)))
    (is (= 10000 (power 10N 4N))))
  (testing "self power function"
    (is (= 32N (self-power 3N)))
    (is (= 10405071317N(self-power 10N)))))

(comment
  (deftest largen-number-self-power-tests
    (testing "self power function"
      (is (= 32N (self-power 3N)))
      (is (= 10405071317N(self-power 10N)))
      (is (= 106876212200059554303215024N(self-power 20N)))
      (is (= 100371115746176445351701210713361941528546861949073514542015172437236580034634746971244943788132460150776779198800002366059871900041784732217539059306483834977865973576751345853385981719448969027641920N (self-power 100N))))))

(comment
  (testing "test solution"
    (is (= "9110846700" (last-chars (str (self-power 1000N)) 10)))))

