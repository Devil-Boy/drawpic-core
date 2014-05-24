# What is Drawpic-Core?
Drawpic-Core is a set of interfaces, classes, and resources that can be shared between any java-based implementation of the Drawpic server or client.

# Why is it in a separate repository?
Having this separate repository allows for a common ground, or standard protocol, that can reduce errors caused by needing to maintain two sets of the same code.

# How will it be used?
It is meant to be "shaded into" the packages of the previously mentioned projects.

In order to do this, one must install the project into their local Maven repository. This is done by running Maven's "install" goal in the project directory.
Afterwards a dependent project can shade it by having the following in their pom.xml

```xml
  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-shade-plugin</artifactId>
        <executions>
          <execution>
            <phase>package</phase>
            <goals>
              <goal>shade</goal>
            </goals>
            <configuration>
              <artifactSet>
                <includes>
                  <include>cse110team4.drawpic:drawpic-core</include>
                </includes>
              </artifactSet>
            </configuration>
          </execution>
        </executions>
      </plugin>
    </plugins>
  </build>
```

# How is Drawpic-Core being developed?
Currently Kervin Sam is in charge of the structure and direction of the core files. It is recommended that other team members give him prior notice before attempting any changes as it could lead to breakage of dependents.

# Notes
- We have not yet established if the event system is going to be of any use for the server, so it may get moved back to client
- We need to start using the Spring framework (dependency inversion) soon. Hopefully somebody can start refactoring before we get too deep into development
- For most cases, it is recommended if there is an interface in here that a dependent can use, it should use it
