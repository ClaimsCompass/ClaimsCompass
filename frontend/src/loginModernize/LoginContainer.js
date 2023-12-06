import React from 'react';
import PropTypes from 'prop-types';
import { Helmet } from 'react-helmet';

const LoginContainer = ({ title, description, children }) => (
  <div>
    <Helmet>
      <title>{title}</title>
      <meta name="description" content={description} />
    </Helmet>
    {children}
  </div>
);

LoginContainer.propTypes = {
  title: PropTypes.string,
  description: PropTypes.string,
  children: PropTypes.node,
};

export default LoginContainer;
