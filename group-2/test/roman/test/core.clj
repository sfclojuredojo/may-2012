(ns roman.test.core
  (:use [roman.core])
  (:use [midje.sweet]))

(fact "Roman numerals"
  (roman-numeral 1) => "I"
  (roman-numeral 2) => "II"
  (roman-numeral 3) => "III"
  (roman-numeral 4) => "IV"
  (roman-numeral 5) => "V"
  (roman-numeral 1999) => "MCMXCIX"
  (roman-numeral 3434) => "MMMCDXXXIV"
  (roman-numeral 21999) => "MMMMMMMMMMMMMMMMMMMMMCMXCIX"
) 

(fact "Symbols for number"
  (symbol-for 0 ["I" "V", "X"]) => ""
  (symbol-for 1 ["I" "V", "X"]) => "I"
  (symbol-for 2 ["I" "V", "X"]) => "II"
  (symbol-for 3 ["I" "V", "X"]) => "III"
  (symbol-for 4 ["I" "V", "X"]) => "IV"
  (symbol-for 5 ["I" "V", "X"]) => "V"
  (symbol-for 6 ["I" "V", "X"]) => "VI"
  (symbol-for 7 ["I" "V", "X"]) => "VII"
  (symbol-for 8 ["I" "V", "X"]) => "VIII"
  (symbol-for 9 ["I" "V", "X"]) => "IX"
  )

(fact "hundreds"
      (hundreds 1111) => "C")

(fact "sequence"
      (nth (roman-sequence) 1998) => "MCMXCIX")
