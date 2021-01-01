/// <reference types="cypress" />

context('Register page', () => {
  beforeEach(() => {
    cy.visit('http://localhost:8081/register');
  })

  it('Two types of registration buttons are available', () => {
  	cy.title().should('include', 'Sign up');
  	cy.contains('Manager');
  	cy.contains('Player');
  })

  it('Manager registration can be opened', () => {
  	cy.title().should('include', 'Sign up');
  	cy.contains('Manager').click();
  	cy.contains('Sign up as a manager');
  	cy.contains('Log in');
  })

  it('Player registration can be opened', () => {
  	cy.title().should('include', 'Sign up');
  	cy.contains('Player').click();
  	cy.contains('Sign up as a player');
  	cy.contains("Height");
	cy.contains("Position");
	cy.contains("Shoots/Catches");
  	cy.contains('Log in');
  })
})