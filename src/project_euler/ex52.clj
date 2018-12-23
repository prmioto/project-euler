(ns project-euler.ex52)

(defn same-digits? [& args]
  (apply = (map #(frequencies (str %)) args)))

(defn get-multiples [n max]
    (map #(* n %) (range 1 (inc max))))
   
(defn multiples-same-digits? [n max]
    (apply same-digits? (get-multiples n max)))
    
(first 
    (filter 
        #(true? (:result %)) 
        (map 
            #(assoc {} :number % :result (multiples-same-digits? % 6)) 
            (iterate inc 1))))