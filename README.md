
# react-native-image-view

## Getting started

`$ npm install react-native-image-view --save`

### Mostly automatic installation

`$ react-native link react-native-image-view`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-image-view` and add `RNImageView.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNImageView.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainApplication.java`
  - Add `import com.reactlibrary.RNImageViewPackage;` to the imports at the top of the file
  - Add `new RNImageViewPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-image-view'
  	project(':react-native-image-view').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-image-view/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-image-view')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNImageView.sln` in `node_modules/react-native-image-view/windows/RNImageView.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Image.View.RNImageView;` to the usings at the top of the file
  - Add `new RNImageViewPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNImageView from 'react-native-image-view';

// TODO: What to do with the module?
RNImageView;
```
  