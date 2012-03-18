(ns wolfram)

(def appid (System/getenv "WOLFRAM_APP_ID"))
(def engine (com.wolfram.alpha.WAEngine.))
(.setAppID engine appid)
(.addFormat engine "plaintext")

(defn query [input]
  (let [query (.createQuery engine)]
    (.setInput query input)
    (let [result (.performQuery engine query)]
      {:pods
       (for [pod (.getPods result)]
         {:title (.getTitle pod)
          :sub-pods
          (for [sub-pod (.getSubpods pod)]
            (for [contents (.getContents sub-pod)]
              (.getText contents)))})})))
