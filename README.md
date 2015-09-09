# Gson Parcelable

**Simple GSON Parceling for Android**

This Android library can be used to quickly add the parceling mechanism to a model object. It is not made for speed, but rather for simplicity.

To use GSON for parceling an Object, follow this example:

We have the `Person` class:

````java
public class Person {
	String name;
	String occupation;
	int age;
}
````

First, `extend GsonParcelable`:

````java
public class Person extends GsonParcelable {
	String name;
	String occupation;
	int age;
}
````

Next, create the Gson instance you want to use. This can be the default Gson for simple models, but more complex models may require more customized Gson instances:

````java
public class Person extends GsonParcelable {
	String name;
	String occupation;
	int age;
	
	static Gson sGson = new Gson();
}
````

Finally, create the `CREATOR` field and implement the required methods:

````java
public class Person extends GsonParcelable {
	String name;
	String occupation;
	int age;
	
	static Gson sGson = new Gson();
	
    public static final GsonCreator<Person> CREATOR = new GsonCreator<Person>(Person.class) {
        @Override
        public Gson getGson() {
            return sGson;
        }
    };

    @Override
    public GsonCreator getCREATOR() {
        return CREATOR;
    }
}
````

That's it! Everything else is handled for you.

## How to import

The easiest way to include this in your project currently is to copy + paste the *gson_parcelable* directory into your project's root directory, and add a reference in the *gradle.settings* file:

    include ':app', ':gson_parcelable'
    
Then re-sync your gradle files.
