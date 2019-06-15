# Scriptorium Core
Common interfaces and classes for Scriptorium libraries.

Scriptorium-family libraries provide fluent APIs for as-you-go output of structured
text formats (e.g., JSON, XML, YAML, HTML). The goal of this Core library is to
provide a solid foundation for developing format-specific libraries, and to allow
interoperation between these libraries for polyglot output.

[JavaDoc](https://scriptorium.codecastle.io/apidocs/scriptorium-core/2.0)

## Change log

### 2.0.0

- Now packaged as a multi-release `jar` with a proper `module-info.class` for Java versions
above 8.
- `FluentNode<P>` no longer implements `Closeable`
- `Inscribable#inscribe(IOFunction)` now returns a new type, `Inscription<P>`

### 1.0.1
Provide an Automatic-Module-Name for forward compatibility 
with the Java 9+ module system: `io.codecastle.scriptorium.core`
