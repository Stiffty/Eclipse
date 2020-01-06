#version 150

in vec3 positions;
in vec2 textureCoordinates;

out vec3 outPositions;
out vec2 outTextureCoordinates;

uniform mat4 transformationMatrix;
uniform mat4 viewMatrix;
uniform mat4 projectionMatrix;

void main(){
	
	vec4 worldPosition = transformationMatrix*vec4(positions,1);
	
	outPositions = worldPosition.xyz;
	outTextureCoordinates = textureCoordinates;
	
	gl_Position = projectionMatrix*viewMatrix*worldPosition;
}