import { AuthorFullNamePipe } from './author-full-name.pipe';

describe('AuthorFullNamePipe', () => {
  it('create an instance', () => {
    const pipe = new AuthorFullNamePipe();
    expect(pipe).toBeTruthy();
  });
});
