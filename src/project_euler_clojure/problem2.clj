; https://projecteuler.net/problem=2
(ns project-euler-clojure.problem2)

(defn fibonaci-numbers 
  ([] (fibonaci-numbers 1N 1N))
  ([a b] 
   (lazy-seq 
     (cons a 
           (fibonaci-numbers b (+ a b)))))
)

(defn solve-fn
  []
  (apply + 
         (filter even? 
                 (take-while #(< % 4000000N) (fibonaci-numbers))))
)

(defn solve
  []
  (println "Problem 2:" (solve-fn))
)
