(ns djp-front.fn
  (:require  [reagent.core :as r :refer [atom]]
             [djp-front.dom :refer [$$ $q]])
  )

(defn webview []
  ($q "webview"))

(defn nav-to [url]
  (.setAttribute  (webview) "src" url)
  )

(defn go-home []
  (print "go home ..." )
  (nav-to "http://baidu.com")
  )

(defn go-back []
  (.goBack (webview)))

(defn go-forward []
  (.goForward (webview)))
