oc set env deployments/globex-mobile --overwrite \
 API_CLIENT_ID=68cb678b \
 GLOBEX_MOBILE_GATEWAY=https://globex-mobile-gateway-product-3scale-user4-apicast-production.apps.cluster-54vds.54vds.sandbox664.opentlc.com:443 \
 SSO_AUTHORITY=https://sso.apps.cluster-54vds.54vds.sandbox664.opentlc.com/auth/realms/globex-user4 \
 SSO_REDIRECT_LOGOUT_URI=https://globex-mobile-globex-apim-user4.apps.cluster-54vds.54vds.sandbox664.opentlc.com/home