javafiles = U.java HTMLCleaner.java HTMLCleanerRunner.java JSoupCleanerRunner.java PrettyPrinter.java
classfiles = $(javafiles:.java=.class)
classpath = .:jsoup-1.8.1.jar

all: $(classfiles)

%.class: %.java
	@echo javac $<
	@javac -classpath $(classpath) $<

clean:
	@echo Deleting all .class files
	@rm -f *.class

watch: all
	@echo Watching for changes...
	@fswatch -o . | xargs -n1 -I{} make -s fromwatch

fromwatch: all
	@echo Watching for changes...

run: all
	java -cp .:jsoup-1.8.1.jar HTMLCleanerRunner
