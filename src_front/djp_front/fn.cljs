(ns djp-front.fn
  (:require  [reagent.core :as r :refer [atom]]
             [djp-front.dom :refer [$$ $q $val]])
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

(defn go-location []
  (let [loc-url ($val "location")]
    (print loc-url)
    (nav-to loc-url)
    )
  )

(defn go-back []
  (.goBack (webview)))

(defn go-forward []
  (.goForward (webview)))

(defn open-dev []
  (.openDevTools (webview))
  )

(set! (.-onload js/window)
      (fn []
        (let [webview (webview)]
          (print webview)
          (.addEventListener webview "did-start-loading"
               (fn []
                 (print "did-start-loading... "))
               )
          )
        )
      )
