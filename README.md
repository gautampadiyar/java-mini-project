# java-mini-project

This program is an event scheduler for college fests meant to be used by attendees. We take event information and primary preferences and fill up the rest of their time with other events depending on their interests.

Input  : using CSV (excel) which is parsed to json and uploaded to firebase

Output : would be a chronological schedule which the attendee can follow to make the best use of his time. This would include  primary preferences and other event suggestions which the user might be interested in.

## Team Members
- Aditya Subramanian
- Gautam Padiyar
- Naijoe Srinivasan

## Dependencies
*gson* - A Java serialization/deserialization library to convert Java Objects into JSON and back

If using netbeans/eclipse (any non gradle based system)
- Download the latest "gson-x.x.x.jar" from http://repo1.maven.org/maven2/com/google/code/gson/gson/2.8.2/

If using Android Studio (any gradle based system)
- Add the following to your build.gradle
```
dependencies {
    compile 'com.google.code.gson:gson:2.8.2'
}
```
