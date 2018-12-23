(ns project-euler.ex607-test
  (:require
    [clojure.test :refer :all]
    [clojure.math.numeric-tower :as math]
    [project-euler.ex607 :refer :all]))

(defn absolute-difference ^double [^double x ^double y]
  (Math/abs (double (- x y))))

(defn relative-difference ^double [^double x ^double y]
  (/ (Math/abs (- x y))
     (max (Math/abs x) (Math/abs y))))

(def difference absolute-difference)

(defn close? [tolerance x y]
  (<= (difference x y) tolerance))

(deftest cross-width-tests
  (testing "45 degres"
    (is (close? 1e-2 0.7071 (Math/cos (Math/toRadians 45.0))))))