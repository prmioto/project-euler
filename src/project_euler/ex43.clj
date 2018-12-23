(ns project-euler.ex43)

(defn get-str-triplets [s]
    (let [l (count s)]
        (map #(subs s % (+ % 3)) (range 1 (- l 2)))))
        
(println (get-str-triplets "0123456789"))
(println (get-str-triplets "1406357289"))

(defn str-to-int [s]
    (Integer/parseInt s))
    
(println (vec (map str-to-int (get-str-triplets "1406357289"))))

(defn get-int-triplets [s]
    (vec (map str-to-int (get-str-triplets s))))

(println (get-int-triplets "1406357289"))
   
(def primes [2 3 5 7 11 13 17])

(every? #(zero? %) (map #(mod %1 %2) (get-int-triplets "1406357289") primes))

(defn is-divisible? [dividends divisors]
    (every? #(zero? %) (map #(mod %1 %2) dividends divisors)))

(defn triplets-divible? [s]
    (let [primes [2 3 5 7 11 13 17]]
        (every? #(zero? %) (map #(mod %1 %2) (get-int-triplets s) primes))))
        
(println (triplets-divible? "1406357289"))
(println (triplets-divible? "0123456789"))