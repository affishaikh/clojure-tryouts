; https://www.codewars.com/kata/520b9d2ad5c005041100000f/train/clojure
; Move the first letter of each word to the end of it, then add "ay" to the end of the word. Leave punctuation marks untouched.
;
; Examples
; (piglatin/pig-it "Pig latin is cool")   -> "igPay atinlay siay oolcay"
; (piglatin/pig-it "Hello world !")       -> "elloHay orldway !"

(defn isPunctuation [word]
      (if-let [n (some #{(int (first word))} (concat (range 48 58) (range 65 91) (range 97 123)))]
              false
              true))

(defn pig-it [s]
      (apply str (rest (reduce
                         #(if (isPunctuation %2) (str %1 " " %2) (str %1 " " (apply str (rest %2)) (first %2) "ay")) ""
                         (clojure.string/split s #" "))))
      )
