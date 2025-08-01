(ns frontend.extensions.code
  (:require ["codemirror" :as CodeMirror]
            ["codemirror/addon/edit/closebrackets"]
            ["codemirror/addon/edit/matchbrackets"]
            ["codemirror/addon/hint/show-hint"]
            ["codemirror/addon/selection/active-line"]
            ["codemirror/mode/apl/apl"]
            ["codemirror/mode/asciiarmor/asciiarmor"]
            ["codemirror/mode/asn.1/asn.1"]
            ["codemirror/mode/asterisk/asterisk"]
            ["codemirror/mode/brainfuck/brainfuck"]
            ["codemirror/mode/clike/clike"]
            ["codemirror/mode/clojure/clojure"]
            ["codemirror/mode/cmake/cmake"]
            ["codemirror/mode/cobol/cobol"]
            ["codemirror/mode/coffeescript/coffeescript"]
            ["codemirror/mode/commonlisp/commonlisp"]
            ["codemirror/mode/crystal/crystal"]
            ["codemirror/mode/css/css"]
            ["codemirror/mode/cypher/cypher"]
            ["codemirror/mode/d/d"]
            ["codemirror/mode/dart/dart"]
            ["codemirror/mode/diff/diff"]
            ["codemirror/mode/django/django"]
            ["codemirror/mode/dockerfile/dockerfile"]
            ["codemirror/mode/dtd/dtd"]
            ["codemirror/mode/dylan/dylan"]
            ["codemirror/mode/ebnf/ebnf"]
            ["codemirror/mode/ecl/ecl"]
            ["codemirror/mode/eiffel/eiffel"]
            ["codemirror/mode/elm/elm"]
            ["codemirror/mode/erlang/erlang"]
            ["codemirror/mode/factor/factor"]
            ["codemirror/mode/fcl/fcl"]
            ["codemirror/mode/forth/forth"]
            ["codemirror/mode/fortran/fortran"]
            ["codemirror/mode/gas/gas"]
            ["codemirror/mode/gfm/gfm"]
            ["codemirror/mode/gherkin/gherkin"]
            ["codemirror/mode/go/go"]
            ["codemirror/mode/groovy/groovy"]
            ["codemirror/mode/haml/haml"]
            ["codemirror/mode/handlebars/handlebars"]
            ["codemirror/mode/haskell-literate/haskell-literate"]
            ["codemirror/mode/haskell/haskell"]
            ["codemirror/mode/haxe/haxe"]
            ["codemirror/mode/htmlembedded/htmlembedded"]
            ["codemirror/mode/htmlmixed/htmlmixed"]
            ["codemirror/mode/http/http"]
            ["codemirror/mode/idl/idl"]
            ["codemirror/mode/javascript/javascript"]
            ["codemirror/mode/jinja2/jinja2"]
            ["codemirror/mode/jsx/jsx"]
            ["codemirror/mode/julia/julia"]
            ["codemirror/mode/livescript/livescript"]
            ["codemirror/mode/lua/lua"]
            ["codemirror/mode/markdown/markdown"]
            ["codemirror/mode/mathematica/mathematica"]
            ["codemirror/mode/mbox/mbox"]
            ["codemirror/mode/meta"]
            ["codemirror/mode/mirc/mirc"]
            ["codemirror/mode/mllike/mllike"]
            ["codemirror/mode/modelica/modelica"]
            ["codemirror/mode/mscgen/mscgen"]
            ["codemirror/mode/mumps/mumps"]
            ["codemirror/mode/nginx/nginx"]
            ["codemirror/mode/nsis/nsis"]
            ["codemirror/mode/ntriples/ntriples"]
            ["codemirror/mode/octave/octave"]
            ["codemirror/mode/oz/oz"]
            ["codemirror/mode/pascal/pascal"]
            ["codemirror/mode/pegjs/pegjs"]
            ["codemirror/mode/perl/perl"]
            ["codemirror/mode/php/php"]
            ["codemirror/mode/pig/pig"]
            ["codemirror/mode/powershell/powershell"]
            ["codemirror/mode/properties/properties"]
            ["codemirror/mode/protobuf/protobuf"]
            ["codemirror/mode/pug/pug"]
            ["codemirror/mode/puppet/puppet"]
            ["codemirror/mode/python/python"]
            ["codemirror/mode/q/q"]
            ["codemirror/mode/r/r"]
            ["codemirror/mode/rpm/rpm"]
            ["codemirror/mode/rst/rst"]
            ["codemirror/mode/ruby/ruby"]
            ["codemirror/mode/rust/rust"]
            ["codemirror/mode/sas/sas"]
            ["codemirror/mode/sass/sass"]
            ["codemirror/mode/scheme/scheme"]
            ["codemirror/mode/shell/shell"]
            ["codemirror/mode/sieve/sieve"]
            ["codemirror/mode/slim/slim"]
            ["codemirror/mode/smalltalk/smalltalk"]
            ["codemirror/mode/smarty/smarty"]
            ["codemirror/mode/solr/solr"]
            ["codemirror/mode/soy/soy"]
            ["codemirror/mode/sparql/sparql"]
            ["codemirror/mode/spreadsheet/spreadsheet"]
            ["codemirror/mode/sql/sql"]
            ["codemirror/mode/stex/stex"]
            ["codemirror/mode/stylus/stylus"]
            ["codemirror/mode/swift/swift"]
            ["codemirror/mode/tcl/tcl"]
            ["codemirror/mode/textile/textile"]
            ["codemirror/mode/tiddlywiki/tiddlywiki"]
            ["codemirror/mode/tiki/tiki"]
            ["codemirror/mode/toml/toml"]
            ["codemirror/mode/tornado/tornado"]
            ["codemirror/mode/troff/troff"]
            ["codemirror/mode/ttcn-cfg/ttcn-cfg"]
            ["codemirror/mode/ttcn/ttcn"]
            ["codemirror/mode/turtle/turtle"]
            ["codemirror/mode/twig/twig"]
            ["codemirror/mode/vb/vb"]
            ["codemirror/mode/vbscript/vbscript"]
            ["codemirror/mode/velocity/velocity"]
            ["codemirror/mode/verilog/verilog"]
            ["codemirror/mode/vhdl/vhdl"]
            ["codemirror/mode/vue/vue"]
            ["codemirror/mode/wast/wast"]
            ["codemirror/mode/webidl/webidl"]
            ["codemirror/mode/xml/xml"]
            ["codemirror/mode/xquery/xquery"]
            ["codemirror/mode/yacas/yacas"]
            ["codemirror/mode/yaml-frontmatter/yaml-frontmatter"]
            ["codemirror/mode/yaml/yaml"]
            ["codemirror/mode/z80/z80"]
            [cljs-bean.core :as bean]
            [clojure.string :as string]
            [frontend.commands :as commands]
            [frontend.config :as config]
            [frontend.db :as db]
            [frontend.extensions.calc :as calc]
            [frontend.handler.code :as code-handler]
            [frontend.handler.editor :as editor-handler]
            [frontend.schema.handler.common-config :refer [Config-edn]]
            [frontend.state :as state]
            [frontend.util :as util]
            [goog.dom :as gdom]
            [goog.object :as gobj]
            [malli.core :as m]
            [promesa.core :as p]
            [rum.core :as rum]))

;; codemirror

(def from-textarea (gobj/get CodeMirror "fromTextArea"))
(def Pos (gobj/get CodeMirror "Pos"))

(def textarea-ref-name "textarea")
(def codemirror-ref-name "codemirror-instance")

;; export CodeMirror to global scope
(set! js/window -CodeMirror CodeMirror)

(defn- all-tokens-by-cursor
  "All tokens from the beginning of the document to the cursor(inclusive)."
  [cm]
  (let [cur (.getCursor cm)
        line (.-line cur)
        pos (.-ch cur)]
    (concat (mapcat #(.getLineTokens cm %) (range line))
            (filter #(<= (.-end %) pos) (.getLineTokens cm line)))))

(defn- tokens->doc-state
  "Parse tokens into document state of the last token."
  [tokens]
  (let [init-state {:current-config-path []
                    :state-stack (list :ok)}]
    (loop [state init-state
           tokens tokens]
      (if (empty? tokens)
        state
        (let [token (first tokens)
              token-type (.-type token)
              token-string (.-string token)
              current-state (first (:state-stack state))
              next-state (cond
                           (or (nil? token-type)
                               (= token-type "comment")
                               (= token-type "meta") ;; TODO: handle meta prefix
                               (= current-state :error))
                           state

                           (= token-type "bracket")
                           (cond
                             ;; ignore map if it is inside a list or vector (query or function)
                             (and (= "{" token-string)
                                  (some #(contains? #{:list :vector} %)
                                        (:state-stack state)))
                             (assoc state :state-stack (conj (:state-stack state) :ignore-map))
                             (= "{" token-string)
                             (assoc state :state-stack (conj (:state-stack state) :map))
                             (= "(" token-string)
                             (assoc state :state-stack (conj (:state-stack state) :list))
                             (= "[" token-string)
                             (assoc state :state-stack (conj (:state-stack state) :vector))

                             (and (= :ignore-map current-state)
                                  (contains? #{"}" ")" "]"} token-string))
                             (assoc state :state-stack (pop (:state-stack state)))

                             (or (and (= "}" token-string) (= :map current-state))
                                 (and (= ")" token-string) (= :list current-state))
                                 (and (= "]" token-string) (= :vector current-state)))
                             (let [new-state-stack (pop (:state-stack state))]
                               (if (= (first new-state-stack) :key)
                                 (assoc state
                                        :state-stack (pop new-state-stack)
                                        :current-config-path (pop (:current-config-path state)))
                                 (assoc state :state-stack (pop (:state-stack state)))))

                             :else
                             (assoc state :state-stack (conj (:state-stack state) :error)))

                           (and (= current-state :map) (= token-type "atom"))
                           (assoc state
                                  :state-stack (conj (:state-stack state) :key)
                                  :current-config-path (conj (:current-config-path state) token-string))

                           (= current-state :key)
                           (assoc state
                                  :state-stack (pop (:state-stack state))
                                  :current-config-path (pop (:current-config-path state)))

                           (or (= current-state :list) (= current-state :vector) (= current-state :ignore-map))
                           state

                           :else
                           (assoc state :state-stack (conj (:state-stack state) :error)))]
          (recur next-state (rest tokens)))))))

(defn- doc-state-at-cursor
  "Parse tokens into document state of last token."
  [cm]
  (let [tokens (all-tokens-by-cursor cm)
        {:keys [current-config-path state-stack]} (tokens->doc-state tokens)
        doc-state (first state-stack)]
    [current-config-path doc-state]))

(defn- malli-type->completion-postfix
  [type]
  (case type
    :string "\"\""
    :map-of "{}"
    :map "{}"
    :set "#{}"
    :vector "[]"
    nil))

;; TODO: mu/to-map-syntax has been deprecated, consider removing usage
(defn -map-syntax-walker [schema _ children _]
  (let [properties (m/properties schema)
        options (m/options schema)
        r (when properties (properties :registry))
        properties (if r (assoc properties :registry (m/-property-registry r options m/-form)) properties)]
    (cond-> {:type (m/type schema)}
      (seq properties) (assoc :properties properties)
      (seq children) (assoc :children children))))

(defn- malli-to-map-syntax
  ([?schema] (malli-to-map-syntax ?schema nil))
  ([?schema options] (m/walk ?schema -map-syntax-walker options)))

(.registerHelper CodeMirror "hint" "clojure"
                 (fn [cm _options]
                   (let [cur (.getCursor cm)
                         token (.getTokenAt cm cur)
                         token-type (.-type token)
                         token-string (.-string token)
                         result (atom {})
                         [config-path doc-state] (doc-state-at-cursor cm)]
                     (cond

                       ;; completion of config keys, triggered by `:` or shortcut
                       (and (= token-type "atom")
                            (string/starts-with? token-string ":")
                            (= doc-state :key))
                       (do
                         (m/walk Config-edn
                                 (fn [schema properties _children _opts]
                                   (let [schema-path (mapv str properties)]
                                     (cond
                                       (empty? schema-path)
                                       nil

                                       (empty? config-path)
                                       (swap! result assoc (first schema-path) (m/type schema))

                                       (= (count config-path) 1)
                                       (when (string/starts-with? (first schema-path) (first config-path))
                                         (swap! result assoc (first schema-path) (m/type schema)))

                                       (= (count config-path) 2)
                                       (when (and (= (count schema-path) 2)
                                                  (= (first schema-path) (first config-path))
                                                  (string/starts-with? (second schema-path) (second config-path)))
                                         (swap! result assoc (second schema-path) (m/type schema)))))
                                   nil))
                         (when (not-empty @result)
                           (let [from (Pos. (.-line cur) (.-start token))
                                 ;; `(.-ch cur)` is the cursor position, not the end of token. When completion is at the middle of a token, this is wrong
                                 to (Pos. (.-line cur) (.-end token))
                                 add-postfix-after? (<= (.-end token) (.-ch cur))
                                 doc (.getValue cm)
                                 list (->> (keys @result)
                                           (remove (fn [text]
                                                     (re-find (re-pattern (str "[^;]*" text "\\s")) doc)))
                                           sort
                                           (map (fn [text]
                                                  (let [type (get @result text)]
                                                    {:text (str text (when add-postfix-after?
                                                                       (str " " (malli-type->completion-postfix type))))
                                                     :displayText (str text "   " type)}))))

                                 completion (clj->js {:list list
                                                      :from from
                                                      :to to})]
                             completion)))

                       ;; completion of :boolean, :enum, :keyword[TODO]
                       (and (nil? token-type)
                            (string/blank? (string/trim token-string))
                            (not-empty config-path)
                            (= doc-state :key))
                       (do
                         (m/walk Config-edn
                                 (fn [schema properties _children _opts]
                                   (let [schema-path (mapv str properties)]
                                     (when (= config-path schema-path)
                                       (case (m/type schema)
                                         :boolean
                                         (swap! result assoc
                                                "true" nil
                                                "false" nil)

                                         :enum
                                         (let [{:keys [children]} (malli-to-map-syntax schema)]
                                           (doseq [child children]
                                             (swap! result assoc (str child) nil)))

                                         nil))
                                     nil)))
                         (when (not-empty @result)
                           (let [from (Pos. (.-line cur) (.-ch cur))
                                 to (Pos. (.-line cur) (.-ch cur))
                                 list (->> (keys @result)
                                           sort
                                           (map (fn [text]
                                                  {:text text
                                                   :displayText text})))
                                 completion (clj->js {:list list
                                                      :from from
                                                      :to to})]
                             completion)))))))

(defn- complete-after
  [cm pred]
  (when (or (not pred) (pred))
    (js/setTimeout
     (fn []
       (when (not (.-completionActive (.-state cm)))
         (.showHint cm #js {:completeSingle false})))
     100))
  (.-Pass CodeMirror))

(defn- extra-codemirror-options []
  (get (state/get-config)
       :editor/extra-codemirror-options {}))

(defn- text->cm-mode
  ([text]
   (text->cm-mode text :name))
  ([text by]
   (when text
     (let [mode (string/lower-case text)
           find-fn-name (case by
                          :name "findModeByName"
                          :ext "findModeByExtension"
                          :file-name "findModeByFileName"
                          "findModeByName")
           find-fn (gobj/get CodeMirror find-fn-name)
           cm-mode (find-fn mode)]
       (if cm-mode
         (.-mime cm-mode)
         mode)))))

(defn- save-editor!
  [config]
  (p/do!
   (code-handler/save-code-editor!)
   (when-let [block (or (:code-block config) (:block config))]
     (let [block (db/entity [:block/uuid (:block/uuid block)])]
       (state/set-state! :editor/raw-mode-block block)
       (editor-handler/edit-block! block :max {:save-code-editor? false})))))

(defn ^:large-vars/cleanup-todo render!
  [state]
  (let [[config id attr _code theme user-options] (:rum/args state)
        edit-block (:block config)
        code-block (:code-block config)
        config-file? (= (:file-path config) "logseq/config.edn")
        _ (state/set-state! :editor/code-mode? false)
        original-mode (get attr :data-lang)
        *editor-ref (get attr :editor-ref)
        mode (if (:file? config)
               (text->cm-mode original-mode :ext) ;; ref: src/main/frontend/components/file.cljs
               (text->cm-mode original-mode :name))
        lisp-like? (contains? #{"scheme" "lisp" "clojure" "edn"} mode)
        config-edit? (and (:file? config) (string/ends-with? (:file-path config) "config.edn"))
        textarea (gdom/getElement id)
        radix-color (state/sub :ui/radix-color)
        default-cm-options {:theme (if radix-color
                                     (str "lsradix " theme)
                                     (str "solarized " theme))
                            :autoCloseBrackets true
                            :lineNumbers true
                            :matchBrackets lisp-like?
                            :styleActiveLine true}
        cm-options (merge default-cm-options
                          (cond-> (extra-codemirror-options)
                            config-file?
                            (dissoc :readOnly))
                          {:mode mode
                           :tabIndex -1 ;; do not accept TAB-in, since TAB is bind globally
                           :extraKeys (merge {"Esc" (fn [cm]
                                                      ;; Avoid reentrancy
                                                      (gobj/set cm "escPressed" true)
                                                      (save-editor! config))}
                                             (when config-edit?
                                               {"':'" complete-after
                                                "Ctrl-Space" "autocomplete"}))}
                          (when config/publishing?
                            {:readOnly true
                             :cursorBlinkRate -1})
                          (when config-edit?
                            {:hintOptions {}})
                          user-options)
        editor (when textarea
                 (from-textarea textarea (clj->js cm-options)))
        _ (when (and editor *editor-ref)
            (reset! *editor-ref editor))]
    (when editor
      (let [textarea-ref (rum/ref-node state textarea-ref-name)
            element (.getWrapperElement editor)
            *cursor-prev (volatile! nil)
            *cursor-curr (volatile! nil)
            update-cursor-state! (fn []
                                   (let [start-pos (.getCursor editor true)
                                         end-pos (.getCursor editor false)
                                         start-pos' (bean/->clj (js/JSON.parse (js/JSON.stringify start-pos)))
                                         end-pos' (bean/->clj (js/JSON.parse (js/JSON.stringify end-pos)))
                                         range {:start (select-keys start-pos' [:line :ch])
                                                :end (select-keys end-pos' [:line :ch])}]
                                     (if (not @*cursor-prev)
                                       (vreset! *cursor-prev range)
                                       (vreset! *cursor-prev @*cursor-curr))
                                     (vreset! *cursor-curr range)))]
        (gobj/set textarea-ref codemirror-ref-name editor)
        (when (= mode "calc")
          (.on editor "change" (fn [_cm _e]
                                 (let [new-code (.getValue editor)]
                                   (reset! (:calc-atom state) (calc/eval-lines new-code))))))
        (.on editor "blur" (fn [cm e]
                             (when e (util/stop e))
                             (let [esc? (gobj/get cm "escPressed")]
                               (when (or (= :file (state/get-current-route))
                                         (not esc?))
                                 (code-handler/save-code-editor!))
                               (state/set-block-component-editing-mode! false)
                               (state/set-state! :editor/code-block-context nil)
                               (when (and (not esc?)
                                          (= (:db/id (state/get-edit-block))
                                             (:db/id edit-block)))
                                 (state/clear-edit!))
                               (vreset! *cursor-curr nil)
                               (vreset! *cursor-prev nil))))
        (.on editor "focus" (fn [_e]
                              (when (and
                                     (contains? #{:code} (:logseq.property.node/display-type code-block))
                                     (not= (:block/uuid edit-block) (:block/uuid (state/get-edit-block))))
                                (editor-handler/edit-block! (or code-block edit-block) :max {:container-id (:container-id config)}))
                              (state/set-block-component-editing-mode! true)
                              (state/set-state! :editor/code-block-context
                                                {:editor editor
                                                 :config config
                                                 :state state})))
        (.on editor "cursorActivity" update-cursor-state!)
        (.addEventListener element "keydown" (fn [e]
                                               (let [key-code (.-code e)
                                                     meta-or-ctrl-pressed? (or (.-ctrlKey e) (.-metaKey e))
                                                     shifted? (.-shiftKey e)]
                                                 (cond
                                                   (contains? #{"ArrowLeft" "ArrowRight"} key-code)
                                                   (let [direction (if (= "ArrowLeft" key-code) :left :right)]
                                                     (when (and (= @*cursor-prev @*cursor-curr)
                                                                (or (and direction (nil? @*cursor-curr))
                                                                    (case direction
                                                                      :left (and (zero? (:line (:start @*cursor-curr)))
                                                                                 (zero? (:ch  (:start @*cursor-curr))))
                                                                      :right (let [line (when-let [line (:line (:end @*cursor-curr))]
                                                                                          (.getLine (.-doc editor) line))]
                                                                               (and (= (:line (:end @*cursor-curr)) (.lastLine editor))
                                                                                    (= (:ch (:end @*cursor-curr)) (count line))))
                                                                      false)))
                                                       (editor-handler/move-to-block-when-cross-boundary direction {}))
                                                     (update-cursor-state!))

                                                   (contains? #{"ArrowUp" "ArrowDown"} key-code)
                                                   (let [direction (if (= "ArrowUp" key-code) :up :down)]
                                                     (when (and (= @*cursor-prev @*cursor-curr)
                                                                (or (and direction (nil? @*cursor-curr))
                                                                    (case direction
                                                                      :up (and (zero? (:line (:start @*cursor-curr)))
                                                                               (zero? (:ch  (:start @*cursor-curr))))
                                                                      :down (let [line (when-let [line (:line (:end @*cursor-curr))]
                                                                                         (.getLine (.-doc editor) line))]
                                                                              (and (= (:line (:end @*cursor-curr)) (.lastLine editor))
                                                                                   (= (:ch (:end @*cursor-curr)) (count line))))
                                                                      false)))
                                                       (editor-handler/move-cross-boundary-up-down
                                                        direction {:input textarea
                                                                   :pos [direction 0]}))
                                                     (update-cursor-state!))
                                                   meta-or-ctrl-pressed?
                                                   ;; prevent default behavior of browser
                                                   ;; Cmd + [ => Go back in browser, outdent in CodeMirror
                                                   ;; Cmd + ] => Go forward in browser, indent in CodeMirror
                                                   (case key-code
                                                     "BracketLeft" (util/stop e)
                                                     "BracketRight" (util/stop e)
                                                     nil)
                                                   shifted?
                                                   (case key-code
                                                     ;; create new block
                                                     "Enter"
                                                     (do
                                                       (util/stop e)
                                                       (when-let [blockid (some-> (.-target e) (.closest "[blockid]") (.getAttribute "blockid"))]
                                                         (code-handler/save-code-editor!)
                                                         (util/schedule #(editor-handler/api-insert-new-block! ""
                                                                                                               {:block-uuid (uuid blockid)
                                                                                                                :sibling? true}))))
                                                     nil)))))
        (.addEventListener element "pointerdown"
                           (fn [e]
                             (.stopPropagation e)
                             (state/clear-selection!)))
        (.addEventListener element "touchstart"
                           (fn [e]
                             (.stopPropagation e)))
        (.save editor)
        (.refresh editor)))
    editor))

(defn- load-and-render!
  [state]
  (let [editor-atom (:editor-atom state)]
    (when-not @editor-atom
      (let [editor (render! state)]
        (reset! editor-atom editor)))))

(defn get-theme! []
  (if (state/sub :ui/radix-color)
    (str "lsradix " (state/sub :ui/theme))
    (str "solarized " (state/sub :ui/theme))))

(rum/defcs editor < rum/reactive
  {:init (fn [state]
           (let [[_ _ _ code _ options] (:rum/args state)]
             (assoc state
                    :editor-atom (atom nil)
                    :calc-atom (atom (calc/eval-lines code))
                    :code-options (atom options)
                    :last-theme (atom (get-theme!)))))
   :did-mount (fn [state]
                (load-and-render! state)
                state)
   :did-update (fn [state]
                 (let [next-theme (get-theme!)
                       last-theme @(:last-theme state)
                       editor' (some-> state :editor-atom deref)]
                   (when (and editor' (not= next-theme last-theme))
                     (reset! (:last-theme state) next-theme)
                     (.setOption editor' "theme" next-theme)))
                 (reset! (:code-options state) (last (:rum/args state)))
                 state)}
  [state _config id attr code _theme _options]
  [:div.extensions__code.flex.flex-1
   (when-let [mode (:data-lang attr)]
     (when-not (= mode "calc")
       [:div.extensions__code-lang
        (string/lower-case mode)]))
   [:div.code-editor.flex.flex-1.flex-row.w-full
    [:textarea (merge {:id id
                       ;; Expose the textarea associated with the CodeMirror instance via
                       ;; ref so that we can autofocus into the CodeMirror instance later.
                       :ref textarea-ref-name
                       :default-value code} attr)]
    (when (= (:data-lang attr) "calc")
      (calc/results (:calc-atom state)))]])

;; Focus into the CodeMirror editor rather than the normal "raw" editor
(defmethod commands/handle-step :codemirror/focus [[_]]
  ;; This requestAnimationFrame is necessary because, for some reason, when you
  ;; type /calculate and then click the "Calculate" command in the dropdown
  ;; *with your mouse* (but not when you do so via your keyboard with the
  ;; arrow + enter keys!), React doesn't re-render before the :codemirror/focus
  ;; command kicks off. As a result, you get an error saying that the node
  ;; you're trying to focus doesn't yet exist. Adding the requestAnimationFrame
  ;; ensures that the React component re-renders before the :codemirror/focus
  ;; command is run. It's not elegant... open to suggestions for how to fix it!
  (let [block (state/get-edit-block)
        block-uuid (:block/uuid block)]
    (p/do!
     (state/pub-event! [:editor/save-current-block])
     (state/clear-edit!)
     (js/setTimeout
      (fn []
        (let [block-node (util/get-first-block-by-id block-uuid)
              textarea-ref (.querySelector block-node "textarea")]
          (when-let [codemirror-ref (gobj/get textarea-ref codemirror-ref-name)]
            (.focus codemirror-ref))))
      256))))
