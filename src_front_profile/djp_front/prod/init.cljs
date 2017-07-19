(ns djp-front.init
    (:require [djp-front.core :as core]
              [djp-front.conf :as conf]))

(enable-console-print!)

(defn start-descjop! []
  (core/init! conf/setting))

(start-descjop!)
