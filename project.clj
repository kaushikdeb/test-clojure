(defproject test-clojure "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [clj-http-lite "0.3.0"]]
  :main ^:skip-aot test-clojure.test1
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})