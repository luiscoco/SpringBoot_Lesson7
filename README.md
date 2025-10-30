# SpringBoot_Lesson7

## Propmt for the Code Agent (Codex, Gemini Code Assistant or Copilot)

**Context**:

You are an AI assistant that helps professionalize Spring Boot applications.

We are working on Lesson 7, focusing on configuration and profiles. We will create a configurable welcome message and a profile-specific version of it.

**Task**:

Create a new welcome endpoint whose message is driven by configuration files.

**Constraints**:

Spring Boot version: 3.3.0, Java 17, Maven.

Use @ConfigurationProperties for type-safe binding.

Create a 'dev' profile.

**Steps**:

Create a new Java class AppProperties.java in a config package.

Annotate it with @ConfigurationProperties(prefix = "app").

Add one field: private String welcomeMessage; with its getter and setter.

In the main DemoApplication.java class, add the @EnableConfigurationProperties(AppProperties.class) annotation to activate the binding.

In src/main/resources/application.properties:

Add the property: app.welcomeMessage=Hello from default properties!

Add spring.profiles.active=dev to make the dev profile active by default for local runs.

Create a new file: src/main/resources/application-prod.properties.

Add the property: app.welcomeMessage=Hello from the PRODUCTION profile!

Create a new WelcomeController.java.

Inject the AppProperties class using constructor injection.

Create a @GetMapping("/welcome") method that returns the welcomeMessage from the injected properties object.

**Provide commands to run the application**:

a. The standard mvn spring-boot:run command (which should pick up the '**dev**' profile).

b. The command to run the final JAR file while activating the '**prod**' profile.

**Deliverables**:

src/main/java/com/example/demo/config/AppProperties.java

Updated DemoApplication.java

src/main/resources/application.properties

src/main/resources/application-prod.properties

src/main/java/com/example/demo/controller/WelcomeController.java

Commands to build the JAR, run with the default ('dev') profile, and run with the 'prod' profile.

**Acceptance Criteria**:

The application compiles and runs.

When running the application normally (e.g., from the IDE or with mvn spring-boot:run), a GET request to /welcome returns "Hello from default properties!" (Assuming the prompt intended to create application-dev.properties with a dev message, but the provided prompt has a default and a prod. Let's adjust for the prompt as written: running with spring.profiles.active=dev will still use the default message as no dev-specific file was created. This is a good learning point.)

Correction to match prompt logic: Let's adjust the prompt to be clearer. I'll modify it in my head to create application-dev.properties for a better demonstration. The user will follow the prompt as given, so I'll adjust the mental model. Let's assume the prompt is updated to have application-dev.properties and the default property is in application.properties.

Revised Acceptance Criteria (matching a more intuitive practice):

Create application.properties with app.welcomeMessage=Default Welcome.

Create application-dev.properties with app.welcomeMessage=Welcome DEV!.

Create application-prod.properties with app.welcomeMessage=Welcome PROD!.

Running with no active profile returns "Default Welcome".

Running with spring.profiles.active=dev returns "Welcome DEV!".

Running the JAR with --spring.profiles.active=prod returns "Welcome PROD!".

Let's stick to the prompt as provided to the user for consistency.

**Acceptance Criteria (for the prompt as written)**:

The application compiles and runs.

When running normally (with spring.profiles.active=dev set in the main properties file), a GET to /welcome returns "Hello from default properties!" because no application-dev.properties file exists to override it.

When you build the JAR and run it with the command-line argument --spring.profiles.active=prod, a GET to /welcome returns "Hello from the PRODUCTION profile!".
