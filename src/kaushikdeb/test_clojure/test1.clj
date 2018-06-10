(ns kaushikdeb.test-clojure.test1
  (:require [clj-http.lite.client :as client])
  (:gen-class))

(defn test-http
  "Test how http client calls work"
  [url]
  (println "URL passed: " url)
  (when url
    (client/get url)))


(defn -main
  "entry point for the app"
  [& args];; expects the URL to be passed in the command line
  (println "Hello, World!")
  (when (and (not (nil? args)) (> (count args) 0));; Go to the next line only if args is passed
    (println "Response status from http client call: " (get (test-http (first args)) :status))))
