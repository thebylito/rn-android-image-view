import React, { Component } from 'react';
import {
  requireNativeComponent,
  ViewPropTypes,
  ImagePropsAndroid,
  UIManager,
  findNodeHandle,
  NativeModules,
  Text,
} from 'react-native';
import PropTypes from 'prop-types';

const resolveAssetSource = require('react-native/Libraries/Image/resolveAssetSource');

const iface = {
  name: 'RNImageViewManager',
  propTypes: {
    width: PropTypes.number,
    height: PropTypes.number,
    src: PropTypes.any,
    ...ViewPropTypes,
  },
};
const RCTRNImageView = requireNativeComponent('RNImageViewManager', iface);

class RNImageViewView extends Component {
  render() {
    const { source: originalSource } = this.props;
    const source = resolveAssetSource(originalSource);

    const { ...props } = this.props;
    const nativeProps = {
      src: source,
      ...props,
    };
    return (
      <RCTRNImageView
        ref={(myView) => {
          this.myView = myView;
        }}
        {...nativeProps}
      />
    );
  }
}

export default RNImageViewView;
