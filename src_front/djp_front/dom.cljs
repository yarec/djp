(ns djp-front.dom)

;;; element
(defn $$ [el-id]
  (.querySelector js/document (str "#" el-id)))

(defn $q [selr]
  (.querySelector js/document selr))

(defn $val [el-id]
  (let [el ($$ el-id)]
    ;;(print el-id)
    (.-value el)))

(defn $attr [el-id key val]
  (let [el ($$ el-id)]
    ;;(print el-id)
    (.setAttribute el key val)))

(defn focus [el-id]
  (let [el ($$ el-id)]
    (print el-id el)
    (when el
      (.focus el))))
