; https://projecteuler.net/problem=6
(ns project-euler-clojure.problem6)


(defn solve-fn
    []
    (Math/abs (-
      (reduce + (map #(* % %) (range 101)))
      (apply * (repeat 2 (reduce + (range 101)))))))

(defn solve []
  (println "Problem 6:" (solve-fn)))
