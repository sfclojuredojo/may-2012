(ns roman.core)

(defn numeral-lookup [symbols] {
        0 ""
        1 (first symbols)
        2 (str (first symbols) (first symbols))
        3 (str (first symbols) (first symbols) (first symbols))
        4 (str (first symbols) (second symbols))
        5 (second symbols)
        6 (str (second symbols) (first symbols))
        7 (str (second symbols) (first symbols) (first symbols))
        8 (str (second symbols) (first symbols) (first symbols) (first symbols))
        9 (str (first symbols) (last symbols))
        })

(defn symbol-for [number symbols]
  (get (numeral-lookup symbols) number))

(defn ones [number]
  (symbol-for (mod number 10) ["I", "V", "X"]))

(defn tens [number]
  (symbol-for (int (/ (mod number 100) 10)) ["X", "L", "C"]))

(defn hundreds [number]
  (symbol-for (int (/ (mod number 1000) 100)) ["C", "D", "M"]))

(defn thousands [number]
  (apply str (take 
               (int (/ number 1000)) 
               (cycle ["M"]))))

(defn roman-numeral [number]
  (str (thousands number) (hundreds number) (tens number) (ones number)))

(defn roman-sequence
      ([] (roman-sequence 1))
      ([n] (lazy-seq (cons (roman-numeral n) (roman-sequence (inc n))))))
