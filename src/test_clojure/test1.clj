(ns test-clojure.test1
  (:require [clj-http.lite.client :as client])
  (:gen-class))

(defn test-http
  "Test how http client calls work"
  [url]
  (println "URL passed: " url)
  (when url
    (client/get url)))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (when (and (not (nil? args)) (> (alength args) 0))
    (println "Response status from http client call: " (get (test-http (get args 0)) :status))))



