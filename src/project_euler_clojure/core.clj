(ns project-euler-clojure.core
  (:require [project-euler-clojure
             helloworld
             problem1
             problem2
             problem3
             problem4
             ]))

(defn get-project-ns []
    (filter #(clojure.string/starts-with?
               (name (ns-name %))
               "project-euler-clojure.")
            (all-ns)))

(defn resolve-solver [target-ns]
  (ns-resolve target-ns (symbol "solve")))


(defn get-problem-solvers [ns-with-problems]
  (filter #(not (nil? %))
          (map resolve-solver ns-with-problems)))


(defn -main [& args]
  (doseq [solver (get-problem-solvers (get-project-ns))]
    (solver))
)
