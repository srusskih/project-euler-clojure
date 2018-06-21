; https://projecteuler.net/problem=5
(ns project-euler-clojure.problem5)


(defn solve-fn
    []
  (loop [n 2]
    (def reminders (map #(if (ratio? (/ n %)) (denominator (/ n %)) 0) (range 2 21)))
    ; (println reminders)
    (def multiplier (first (filter #(not= 0 %) reminders)))
    ; (println multiplier)
    (if (nil? multiplier)
      n
      (recur (* n multiplier)))))

(defn solve []
  (println "Problem 5:" (solve-fn)))
