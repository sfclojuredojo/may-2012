(ns may-2012.core)

(defn -main
  "I don't do a whole lot."
  [& args]
  (println "Hello, World!"))

(defn roman-helper [t f u]
  {1 u, 2 (str u u), 3 (str u u u), 4 (str u f), 5 f,
   6 (str f u), 7 (str f u u), 8 (str f u u u), 9 (str u t), 10 t})

(def units-lookup (roman-helper "x" "v" "i"))
(def tens-lookup (roman-helper "c" "l" "x"))
(def hundreds-lookup (roman-helper "m" "d" "c"))
(def thousands-lookup (roman-helper "?" "mmm" "m"))

(defn roman [n]
  (if (= n 5000) "v"
      (let [thousands (int (/ n 1000))
            hundreds (mod (int (/ n 100)) 10)
            tens (mod (int (/ n 10)) 10)
            units (mod n 10) ]
        (str (thousands-lookup thousands)
             (hundreds-lookup hundreds)
             (tens-lookup tens)
             (units-lookup units)))))

(def romans-seq (map roman (iterate inc 1)))

(defn table [n]
  (clojure.pprint/print-table
   (for [i (range 1 (inc n)) ]
     (into {} (for [j (range 1 (inc n)) ]
                ((juxt identity #(roman (* i %))) j))))))