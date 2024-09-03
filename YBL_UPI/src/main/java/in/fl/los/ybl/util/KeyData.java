
package in.fl.los.ybl.util;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "keyData", "ivToken", "keyId", "encType", "pubKeyPath", "privKeyPath", "keyPwd", "chType",
		"pgpFlag", "privKeyIndex", "pubKeyIndex", "keystorePwd", "keystorePath" })
@Generated("jsonschema2pojo")
public class KeyData {

	@JsonProperty("keyData")
	private Object keyData;
	@JsonProperty("ivToken")
	private Object ivToken;
	@JsonProperty("keyId")
	private Integer keyId;
	@JsonProperty("encType")
	private Object encType;
	@JsonProperty("pubKeyPath")
	private Object pubKeyPath;
	@JsonProperty("privKeyPath")
	private Object privKeyPath;
	@JsonProperty("keyPwd")
	private Object keyPwd;
	@JsonProperty("chType")
	private Object chType;
	@JsonProperty("pgpFlag")
	private Object pgpFlag;
	@JsonProperty("privKeyIndex")
	private Object privKeyIndex;
	@JsonProperty("pubKeyIndex")
	private Object pubKeyIndex;
	@JsonProperty("keystorePwd")
	private Object keystorePwd;
	@JsonProperty("keystorePath")
	private Object keystorePath;

	@JsonProperty("keyData")
	public Object getKeyData() {
		return keyData;
	}

	@JsonProperty("keyData")
	public void setKeyData(Object keyData) {
		this.keyData = keyData;
	}

	@JsonProperty("ivToken")
	public Object getIvToken() {
		return ivToken;
	}

	@JsonProperty("ivToken")
	public void setIvToken(Object ivToken) {
		this.ivToken = ivToken;
	}

	@JsonProperty("keyId")
	public Integer getKeyId() {
		return keyId;
	}

	@JsonProperty("keyId")
	public void setKeyId(Integer keyId) {
		this.keyId = keyId;
	}

	@JsonProperty("encType")
	public Object getEncType() {
		return encType;
	}

	@JsonProperty("encType")
	public void setEncType(Object encType) {
		this.encType = encType;
	}

	@JsonProperty("pubKeyPath")
	public Object getPubKeyPath() {
		return pubKeyPath;
	}

	@JsonProperty("pubKeyPath")
	public void setPubKeyPath(Object pubKeyPath) {
		this.pubKeyPath = pubKeyPath;
	}

	@JsonProperty("privKeyPath")
	public Object getPrivKeyPath() {
		return privKeyPath;
	}

	@JsonProperty("privKeyPath")
	public void setPrivKeyPath(Object privKeyPath) {
		this.privKeyPath = privKeyPath;
	}

	@JsonProperty("keyPwd")
	public Object getKeyPwd() {
		return keyPwd;
	}

	@JsonProperty("keyPwd")
	public void setKeyPwd(Object keyPwd) {
		this.keyPwd = keyPwd;
	}

	@JsonProperty("chType")
	public Object getChType() {
		return chType;
	}

	@JsonProperty("chType")
	public void setChType(Object chType) {
		this.chType = chType;
	}

	@JsonProperty("pgpFlag")
	public Object getPgpFlag() {
		return pgpFlag;
	}

	@JsonProperty("pgpFlag")
	public void setPgpFlag(Object pgpFlag) {
		this.pgpFlag = pgpFlag;
	}

	@JsonProperty("privKeyIndex")
	public Object getPrivKeyIndex() {
		return privKeyIndex;
	}

	@JsonProperty("privKeyIndex")
	public void setPrivKeyIndex(Object privKeyIndex) {
		this.privKeyIndex = privKeyIndex;
	}

	@JsonProperty("pubKeyIndex")
	public Object getPubKeyIndex() {
		return pubKeyIndex;
	}

	@JsonProperty("pubKeyIndex")
	public void setPubKeyIndex(Object pubKeyIndex) {
		this.pubKeyIndex = pubKeyIndex;
	}

	@JsonProperty("keystorePwd")
	public Object getKeystorePwd() {
		return keystorePwd;
	}

	@JsonProperty("keystorePwd")
	public void setKeystorePwd(Object keystorePwd) {
		this.keystorePwd = keystorePwd;
	}

	@JsonProperty("keystorePath")
	public Object getKeystorePath() {
		return keystorePath;
	}

	@JsonProperty("keystorePath")
	public void setKeystorePath(Object keystorePath) {
		this.keystorePath = keystorePath;
	}

	@Override
	public String toString() {
		return String.format(
				"KeyData [keyData=%s, ivToken=%s, keyId=%s, encType=%s, pubKeyPath=%s, privKeyPath=%s, keyPwd=%s, chType=%s, pgpFlag=%s, privKeyIndex=%s, pubKeyIndex=%s, keystorePwd=%s, keystorePath=%s, getClass()=%s, hashCode()=%s, toString()=%s]",
				keyData, ivToken, keyId, encType, pubKeyPath, privKeyPath, keyPwd, chType, pgpFlag, privKeyIndex,
				pubKeyIndex, keystorePwd, keystorePath, getClass(), hashCode(), super.toString());
	}

}
