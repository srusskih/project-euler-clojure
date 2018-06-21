(ns project-euler-clojure.problem4
  (:require [clojure.string :as string]))

(defn is-polindrom
  [d]
  (def sd (str d))
  (-> sd
      string/reverse
      (= sd)))

(defn solve-fn
  []
  (apply max (map #(if (is-polindrom %) % 0)
                  (for [i (range 100 1000) j (range 100 1000)] (* i j)))))


(defn solve []
  (println "Problem 4:" (solve-fn)))
